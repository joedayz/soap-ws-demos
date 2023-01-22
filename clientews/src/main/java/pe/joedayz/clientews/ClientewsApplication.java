package pe.joedayz.clientews;

import java.util.HashMap;
import java.util.Map;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.message.Message;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.joedayz.sumservice.schema.GetSumRequest;
import pe.joedayz.sumservice.wsdl.SumService;
import pe.joedayz.sumservice.wsdl.SumServicePort;

@SpringBootApplication
public class ClientewsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ClientewsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SumService sumService = new SumService();
		SumServicePort sumServicePort = sumService.getSumServiceSOAPBinding();

		Client client = ClientProxy.getClient(sumServicePort);
		Endpoint endpoint = client.getEndpoint();

		client.getRequestContext().put(Message.ENDPOINT_ADDRESS, "http://localhost:8083/services/soap/SumService");

		Map<String, Object> props = new HashMap<>();
		props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
		props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_DIGEST);
		props.put(WSHandlerConstants.PW_CALLBACK_CLASS, UsernameTokenClientCallbackHandler.class.getName());
		props.put(WSHandlerConstants.USER, "admin");

		WSS4JOutInterceptor wss4JOutInterceptor = new WSS4JOutInterceptor(props);
		endpoint.getOutInterceptors().add(wss4JOutInterceptor);

		GetSumRequest request = new GetSumRequest();
		request.setAddendOne(1);
		request.setAddendTwo(5);
		System.out.println(sumServicePort.getSum(request).getResult());
	}


}
