# aliyun-pai-ab-java-sdk

Java sdk for PAI-ABTest  server. Aliyun product docoment [link](https://help.aliyun.com/zh/pai/user-guide/a-b-experiment/?spm=a2c4g.11174283.0.0.3416527fVzoan7).

## Installation
```
<dependency>
  <groupId>com.aliyun.openservices.aiservice</groupId>
  <artifactId>pai-abtest-sdk</artifactId>
  <version>1.0.1</version>
</dependency>
```

## Usage

```java

package com.aliyun.openservices.paiabtest;

import com.aliyun.openservices.paiabtest.api.ApiClient;
import com.aliyun.openservices.paiabtest.api.Configuration;
import com.aliyun.openservices.paiabtest.model.ExperimentContext;
import com.aliyun.openservices.paiabtest.model.ExperimentResult;

import java.util.HashMap;
import java.util.Map;

public class ExperimentTest {
    static ExperimentClient experimentClient;

    public static void main(String[] args) throws Exception {
        // set up experiment client
        String regionId = "cn-beijing";
        String accessId = System.getenv("ALIBABA_CLOUD_ACCESS_KEY_ID");
        String accessKey = System.getenv("ALIBABA_CLOUD_ACCESS_KEY_SECRET");
        Configuration configuration = new Configuration(regionId, accessId, accessKey);
        ApiClient apiClient = new ApiClient(configuration);
        experimentClient = new ExperimentClient(apiClient);

        // init load experiment data
        experimentClient.init();

        // set up experiment context
        ExperimentContext experimentContext = new ExperimentContext();
        experimentContext.setRequestId("req_id");
        // set uid
        experimentContext.setUid("149");
        // set filter params for condition filter match
        Map<String, Object> filterParams = new HashMap<>();
        filterParams.put("sex", "male");
        experimentContext.setFilterParams(filterParams);

        // match experiment
        ExperimentResult experimentResult =  experimentClient.matchExperiment("DefaultProject", experimentContext);

        // print experiment info
        System.out.println(experimentResult.info());
        // print exp id
        System.out.println(experimentResult.getExpId());
        // print exp params
        System.out.println(experimentResult.getExperimentParams().get("recall_v", "not exist"));
        System.out.println(experimentResult.getExperimentParams().get("rank_v", "not exist"));
        System.out.println(experimentResult.getExperimentParams().get("male_v", "not exist"));
    }
}
```


## Version Release Notes 
1.0.1 (2025-06-30)
* Fix domain buckets fetch error 
 
  1.0.0 (2024-07-26) 
* Initial release