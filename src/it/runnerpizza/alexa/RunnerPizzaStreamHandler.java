package it.runnerpizza.alexa;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import it.runnerpizza.alexa.handlers.*;

public class RunnerPizzaStreamHandler extends SkillStreamHandler {

	private static final String SKILL_ID = "";

	private static Skill getSkill() {
		return Skills.standard()
				.addRequestHandlers(
						new OrderPizzaIntentHandler(),
						new NewOrderIntentHandler(),
						new ConfirmOrderIntentHandler(),
						new FallbackIntentHandler(),
						new StopHandler(),
						new HelpIntentHandler(),
						new LaunchHandler(),
						new SessionEndedHandler(),
						new ErrorHandler()
				)
				.withSkillId(SKILL_ID)
				.build();
	}

	public RunnerPizzaStreamHandler() {
		super(getSkill());
	}
}
