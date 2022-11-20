package mg.giz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mg.giz.commun.StorageProperties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;

@RunWith(SpringRunner.class)
@EnableConfigurationProperties(StorageProperties.class)
@SpringBootTest
public class GizDevApplicationTests {

	@Test
	public void contextLoads() {
	}

}
