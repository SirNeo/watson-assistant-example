package es.jmpalma.watson;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.watson.developer_cloud.assistant.v1.Assistant;
import com.ibm.watson.developer_cloud.assistant.v1.model.InputData;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.assistant.v1.model.MessageResponse;

@RestController
public class AssistantController {
	
	@RequestMapping("/")
	public String init() {
		
		Assistant service = new Assistant("2018-04-29");
		service.setUsernameAndPassword("<username>", "<password>");
		
		InputData input = new InputData.Builder("Hi").build();
	
		MessageOptions options = new MessageOptions.Builder("<workspace_id>")
		  .input(input)
		  .build();
		
		MessageResponse response = service.message(options).execute();
		
		System.out.println(response);
				
		return "Hello";
	}
		
}
