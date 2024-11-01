package com.ohgiraffers.forward;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/* comment.
*   value 속성은 생략이 가능하다.
*   어떤 시점에 생략이 가능하냐면
*   @WebServlet 의 속성이 하나일 때만 생략이 가능하다
* */

@WebServlet(value = "/forward")
public class ReceiveRequestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req
            , HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("POST 요청 수락됨...");
        
        // input 타입의 name 속성 값으로 value 를 얻을 수 있다
        String id = req.getParameter("userId");
        String pwd = req.getParameter("userPwd");

        System.out.println("id = " + id);
        System.out.println("pwd = " + pwd);

        // 데이터 베이스 관련 비즈니스 로직
        // 작성하는 공간

        // 사용자에게 어떤 화면을 보여줄 지 결정
        // 해야 할 일이 많기 때문에 응답을 잘하는 서블릿에게
        // 할 일을 위임

        // key, value 형식으로 위임 할 서블릿에게
        // 필요한 값 제공
        req.setAttribute("id", id);

        // 요청을 다시 보낼 수 있게 만드는
        RequestDispatcher rd = req.getRequestDispatcher("response");
        rd.forward(req, resp);
    }
}