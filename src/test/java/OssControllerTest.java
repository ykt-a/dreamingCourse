import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.io.FileInputStream;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class OssControllerTest {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;

    @Before
    public void setupMockMvc(){
        mvc = MockMvcBuilders.webAppContextSetup(wac).build(); //初始化MockMvc对象
    }
    @Test
    public void fileTest() throws Exception {
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.fileUpload("/toUpLoadFile").
                file(new MockMultipartFile("file", "测试", "multipart/form-data", new FileInputStream(new File("D:/测试.avi")))));
        MvcResult mvcResult = resultActions.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("==========结果为：==========\n" + result + "\n");

    }


}


