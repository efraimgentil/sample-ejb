package me.efraimgentil.samplejeejsf.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class MyRenderResponsePhaseListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Response renderd");
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		// TODO Auto-generated method stub
		System.out.println("Rendering response");
	}


	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
