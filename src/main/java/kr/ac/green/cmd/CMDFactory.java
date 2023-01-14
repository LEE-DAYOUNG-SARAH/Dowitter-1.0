package kr.ac.green.cmd;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;

public class CMDFactory {
	//field
	private static Hashtable<String, ICMD> cmds;
	
	//init
	public static void init() {
		if(cmds == null) {
			cmds = new Hashtable<String, ICMD>();
			cmds.put("/start.do", new StartCMD());
			cmds.put("/goJoin.do", new GoJoinCMD());
			cmds.put("/cancelJoin.do", new CancelJoinCMD());
			cmds.put("/doJoin.do", new DoJoinCMD());
			cmds.put("/joinOk.do", new JoinOkCMD());
			cmds.put("/login.do", new LoginCMD());
			cmds.put("/goTimeline.do", new GoTimelineCMD());
			cmds.put("/goMyFeed.do", new GoMyFeedCMD());
			cmds.put("/goModify.do", new GoModifyCMD());
			cmds.put("/logout.do", new LogoutCMD());
			cmds.put("/goWithdraw.do", new GoWithdrawCMD());
			cmds.put("/accessDenied.do", new AccessDeniedCMD());
			cmds.put("/cancelModify.do", new CancelModifyCMD());
			cmds.put("/doModify.do", new DoModifyCMD());
			cmds.put("/afterModify.do", new AfterModifyCMD());
			cmds.put("/cancelModfy.do", new CancelModifyCMD());
			cmds.put("/doWithdraw.do", new DoWithdrawCMD());
			cmds.put("/afterWithdraw.do", new AfterWithdrawCMD());
			//DOC
			cmds.put("/doWriteTimeline.do", new DoWriteTimelineCMD());
			cmds.put("/doWriteMyFeed.do", new DoWriteMyFeedCMD());
			cmds.put("/doDeleteTimeline.do", new DoDeleteTimelineCMD());
			cmds.put("/doDeleteMyFeed.do", new DoDeleteMyFeedCMD());
			cmds.put("/doUpdateTimeline.do", new DoUpdateTimelineCMD());
			cmds.put("/doUpdateMyFeed.do", new DoUpdateMyFeedCMD());
		}
	}
	
	//doAction
	public static String doAction(HttpServletRequest request, String cmd) {
		return cmds.get(cmd).action(request);
	}
}
