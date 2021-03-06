/*
 *  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied. See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 *  WSO2 API Manager - Publisher API
 *  This specifies a **RESTful API** for WSO2 **API Manager** - Publisher.  Please see [full swagger definition](https://raw.githubusercontent.com/wso2/carbon-apimgt/v6.0.4/components/apimgt/org.wso2.carbon.apimgt.rest.api.publisher/src/main/resources/publisher-api.yaml) of the API which is written using [swagger 2.0](http://swagger.io/) specification.
 *
 *  OpenAPI spec version: 0.10.0
 *  Contact: architecture@wso2.com
 *
 *  NOTE: This class is auto generated by the swagger code generator program.
 *  https://github.com/swagger-api/swagger-codegen.git
 *  Do not edit the class manually.
 *
 */

package org.wso2.carbon.apimgt.rest.integration.tests.api.publisher;

import org.testng.annotations.AfterClass;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.ApiException;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.api.APICollectionApi;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.api.APIIndividualApi;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.api.ExportConfigurationApi;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.wso2.carbon.apimgt.rest.integration.tests.publisher.model.APIList;

/**
 * API tests for ExportConfigurationApi
 */
public class ExportConfigurationApiIT {

    private final ExportConfigurationApi api = new ExportConfigurationApi();
    private final TestUtils testUtils = new TestUtils();
    private final APICollectionApi apiSetup = new APICollectionApi();
    private final APIIndividualApi apiIndividualApi = new APIIndividualApi();

    /**
     * FAILS
     * Please refer https://github.com/wso2/product-apim/issues/1622
     * Therefore making this method disabled.
     */

    @Test(enabled = false)
    public void exportApisGetTest() throws ApiException {
        testUtils.createApi("API-180", "1.0.0", "API-180");
        String query = "API-180";
        Integer limit = 10;
        Integer offset = 0;
        File response = api.exportApisGet(query, limit, offset);
    }

    @AfterClass
    public void afterClass() throws ApiException {
        APIList response = apiSetup.apisGet(10, 0, null, null);
        for (int i = 0; i < response.getCount(); i++) {
            apiIndividualApi.apisApiIdDelete(response.getList().get(i).getId(), null, null);
        }
    }

}
