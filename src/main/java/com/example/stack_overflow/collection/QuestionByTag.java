package com.example.stack_overflow.collection;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "question_by_tag")
@Data
public class QuestionByTag {
    private Question question;
    private String tag;
    private Long score;
}
/* recommendation service populates this table whenever a new question is added or an upvote or comment takes place

it decides on the bases of elastic search recommendation for that tag, no of comments, no of upvotes
for example it takes from elastic search top 100 result and make a score out of order of elastic search,trending , comments upvotes,no of views
we can give custom function to ealstic search as well
or can get score of a question for a particular query
so we can get that score + trending score + ... and make a cumulative score based on their weightage for each question and update the score
GET /my_index/_search
{
  "query": {
    "function_score": {
      "query": {
        "match": {
          "content": "Elasticsearch tutorial"
        }
      },
      "functions": [
        {
          "script_score": {
            "script": {
              "source": """
                def features = [
                  doc['popularity'].value,
                  doc['views'].value,
                  _score
                ];
                return call_model('http://model-service/predict', features);
              """
            }
          }
        }
      ],
      "boost_mode": "replace"
    }
  }
}
 */