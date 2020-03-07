# Ajax와 JSON을 활용한 회원게시판 
* 언어 : JavaScript, JSP, Ajax, JSON, HTML/CSS, Bootstrap  
* 개발도구 : Tomcat 8.5, Eclipse, My-SQL  
* 기능: 회원 등록, 검색  

# 소개
* 회원 목록을 확인할 수 있는 간단한 홈페이지입니다. Ajax로 구현하여 회원 이름 검색시 따로 페이지 로딩 없이  
회원의 정보를 출력하고, 검색창에 글자를 입력할때마다 함수가 실행되도록 하여 회원 이름을 완벽히 검색하지 않아도  
해당 글자가 포함된 회원의 목록을 모두 출력할 수 있도록 하였습니다.   

* 회원 등록 기능을 구현하여 간단히 이름, 나이, 성별, 이메일 정보를 기입하면 이또한 페이지 로딩없이 목록 리스트에 추가됩니다.

* JDBC와의 연동을 위해 Connection Pool을 사용하였습니다.

# 실행 방법
1. 해당 프로젝트를 Eclipse에 import합니다.  

2. Connection Pool이 작동하는지 connect 여부를 확인합니다.

3. 아래를 참고하여 user테이블을 생성합니다.
```
CREATE TABLE user (
  userName varchar(20) DEFAULT NULL,
  userAge int(11) DEFAULT NULL,
  userGender varchar(20) DEFAULT NULL,
  userEmail varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8
```

4. WebConent폴더의 index.jsp 파일을 실행하여 홈페이지를 사용할 수 있습니다.


## Developer Information
> email : wldn7076@naver.com
