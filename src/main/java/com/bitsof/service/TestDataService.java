package com.bitsof.service;

import com.bitsof.config.DBConfig;
import com.bitsof.model.TestData;
import com.bitsof.model.Account;
import com.bitsof.model.push.jobs.PushChangesJobs;
import com.bitsof.model.pull.jobs.PullChangesJobs;
import com.bitsof.model.push.jobs.PushChangesJobsWrapper;
import com.bitsof.model.pull.jobs.PullChangesJobsWrapper;

import com.bitsof.utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestDataService {

    public TestData getTestDataById(String testCaseId) {
        String query = "SELECT * FROM public.test_data WHERE test_case_id = ?";

        try (Connection conn = DBConfig.getDataSource().getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, testCaseId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                TestData data = new TestData();
                data.setTestCaseId(rs.getString("test_case_id"));
                data.setTestPlatform(rs.getString("test_platform"));
                data.setEnv(rs.getString("env"));

                data.setAccount(DatabaseUtils.parseJsonColumn(rs, "account", Account.class));

                data.setTestData(DatabaseUtils.parseJsonColumn(rs, "test_data", java.util.Map.class));

                data.setExpectedResultData(
                        DatabaseUtils.parseJsonColumn(rs, "expected_result_data", java.util.Map.class));

                PushChangesJobsWrapper pushChangesWrapper = DatabaseUtils.parseJsonColumn(rs, "push_changes",
                        PushChangesJobsWrapper.class);
                data.setPushChanges(pushChangesWrapper != null ? pushChangesWrapper.getJobs() : null);

                PullChangesJobsWrapper pullChangesWrapper = DatabaseUtils.parseJsonColumn(rs, "pull_changes",
                        PullChangesJobsWrapper.class);
                data.setPullChanges(pullChangesWrapper != null ? pullChangesWrapper.getJobs() : null);

                return data;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
