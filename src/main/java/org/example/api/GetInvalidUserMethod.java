package org.example.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/posts/9999", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/users/_get_invalid/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.NOT_FOUND_404)
public class GetInvalidUserMethod extends AbstractApiMethodV2 {

    public GetInvalidUserMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
