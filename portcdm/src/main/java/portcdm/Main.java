package portcdm;

import se.viktoria.stm.portcdm.connector.common.SubmissionService;
import se.viktoria.util.*;
import java.util.*;
import java.util.function.Predicate;

import eu.portcdm.messaging.PortCallMessage;

public class Main {

	public static void main(String[] args) {
		Configuration configuration = new Configuration(
				"config",
				"/",
				new Predicate<Map.Entry<Object,Object>>() {
					@Override
					public boolean test(Map.Entry<Object,Object> objectObjectEntry) {
						return !objectObjectEntry.getKey().toString().equals("pass");
					}
				});
		configuration.reload();
		
		// ** Create a submission service and add connectors
		SubmissionService submissionService;
		submissionService = new SubmissionService();
		submissionService.addConnectors(configuration);
		
		// ** Create al ist of port call amessages (somehow)
		//List<PortCallMessage> messages;
		// messages = createMEssages();
		// ** Submit the messages
		//submissionService.submitUpdates(messages);
	}

}
