package controller;

import dao.*;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class IndexController implements Controller { 
	private PlayerDao playerDao;
	public void setPlayerDao(PlayerDao player) 
	{
		playerDao = player;
	}
	
  public ModelAndView handleRequest(HttpServletRequest request, 
                   HttpServletResponse response) throws Exception {
    //��ǰ ����Ʈ ������ ���
    List<Player> playerList = this.playerDao.getPlayerList();
    //�� �ۼ�    
	Map<String, List<Player>> model = new HashMap<String, List<Player>>();
    model.put("playerList", playerList);
    //��ȯ���� �Ǵ� ModelAndView�ν��Ͻ��� �ۼ�
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("/WEB-INF/jsp/index.jsp");
    modelAndView.addAllObjects(model);
    return modelAndView;
  }
}
