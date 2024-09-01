package com.example.stack_overflow.service.impl;

import com.example.stack_overflow.collection.Answer;
import com.example.stack_overflow.collection.Question;
import com.example.stack_overflow.collection.QuestionByTag;
import com.example.stack_overflow.dto.QuestionByTagListDto;
import com.example.stack_overflow.dto.QuestionWithAnswerDto;
import com.example.stack_overflow.repository.AnswerRepository;
import com.example.stack_overflow.repository.QuestionByTagRepository;
import com.example.stack_overflow.repository.QuestionRepository;
import com.example.stack_overflow.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.stack_overflow.Constant.LIMIT_OF_CACHED_RESULT;

@Service
@Slf4j
public class QuestionServiceImpl implements QuestionService {

    static final Logger logger = LoggerFactory.getLogger(QuestionServiceImpl.class);
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private QuestionByTagRepository questionByTagRepository;
    @Override
    public QuestionWithAnswerDto getQuestionWithAnswerDto(String questionId, int pageNumber, int pageSize, String orderBy) {
        try {

            QuestionWithAnswerDto questionWithAnswerDto = new QuestionWithAnswerDto();
            Question question = questionRepository.findById(questionId).orElse(null);
            if(question == null) {
                throw new Exception("questionId not found");
            }

            //TODO if answer is null there is no answer
            questionWithAnswerDto.setQuestion(question.getContent());
            if (pageNumber * pageSize <= LIMIT_OF_CACHED_RESULT) {
                //check in redis cache first

                questionWithAnswerDto.setAnswers(question.getAnswers());
                questionWithAnswerDto.setTotalAnswers(question.getTotalAnswers());
                //put in redis cache with defined TTl
                //can also fill cache for other order by and other pages
            } else {
                Pageable pageable = PageRequest.of(pageNumber, pageSize);
                Page<Answer> page = answerRepository.findByParentId(questionId, pageable, orderBy);
                List<Answer> list = page.getContent();
                questionWithAnswerDto.setAnswers(list);
                questionWithAnswerDto.setTotalAnswers(page.getTotalElements());
            }
            // can use slice for exact response
            return questionWithAnswerDto;


        }
        catch (Exception e) {
            log.error("Something went wrong, exception:{}, questionId:{}, pageNumber:{}, pageSize:{}",e, questionId, pageNumber, pageSize);
            return null;
        }
    }

    @Override
    public QuestionByTagListDto getQuestionForTag(String tag, int pageNumber, int pageSize) {
        try {
            //check in redis cache first
            Pageable pageable = PageRequest.of(pageNumber, pageSize);
            Page<QuestionByTag> questionByTagPage = questionByTagRepository.findByTagOrderByScoreDesc(tag, pageable);
            QuestionByTagListDto questionByTagListDto = new QuestionByTagListDto();
            questionByTagListDto.setQuestion(questionByTagPage.getContent());
            questionByTagListDto.setTotalQuestions(questionByTagPage.getTotalElements());
            //put in redis cache with defined TTl
            return questionByTagListDto;
        }
        catch (Exception e) {
            log.error("Something went wrong, {}",e);
            return null;

        }

    }
}
