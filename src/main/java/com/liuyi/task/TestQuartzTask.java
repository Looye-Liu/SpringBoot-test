package com.liuyi.task;

import com.liuyi.job.TestQuartzJob;
import org.springframework.stereotype.Service;

/**
 * Created by looye on 2017/11/18.
 *
 * @author looye
 * @date 2017/11/18
 */
@Service
public class TestQuartzTask extends BaseQuartzTask {
    TestQuartzTask() {
        super("job3", "group2", "0/5 * * ? * *", TestQuartzJob.class);
    }
}
