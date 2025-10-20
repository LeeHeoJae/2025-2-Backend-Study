스프링 계층형 아키텍처  
브라우저 <DTO> 컨트롤러 <DTO> 서비스 <DTO> DAO <Entity> DB  

계층형 패키지 구조: 기능별로 나눈다.  
도메인형: 도메인 관련 클래스로 나눈다.  

상태 코드: 
 1. 200 OK
 2. 201 Created
 3. 204 No Content
 4. 400 Bad Request
 5. 404 Not Found
 6. 500 Internal Sever Error

원자성(transaction): 메소드 세 개가 셋 다 실행되거나 셋 다 실행 안 되거나 하도록 하는 성질  
의존성: 내가 의존하는 객체를 직접 생성하지 않고 밖에서 주입 받는 성질.  
    매번 필요한 객체를 생성하지 않아서 효율적임