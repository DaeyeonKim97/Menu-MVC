# Quick Start

---

1. Tomcat server 추가
2. Tomcat server에 menu-mvc-mybatis 프로젝트 추가
3. **menu-mvc-mybatis / config / [connection-info.properties](http://connection-info.properties) 수정**
    
    ```xml
    DRIVER = oracle.jdbc.driver.OracleDriver
    URL = jdbc:oracle:thin:@localhost:1521:xe
    USER = ~~데이터베이스유저이름(C##GREEDY)~~
    PASSWORD = ~~데이터베이스패스워드(GREEDY)~~
    ```
    
4. Tomcat server 시작

# Summary

---

### 변경된 사항

- Mybatis
    - association
    - collection
    - properties 분리
    - 입력값 별 데이터 처리 : mybatis mapper xml
- Servlet
    - 서버를 열 때 mybatis preloading
    - Encoding Filter
    - Exception handling
- JSP
    - HTML 유효성 검사
    - Error 세분화
    - jstl core if → 0개 데이터 조회 제외
