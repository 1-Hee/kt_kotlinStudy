# :floppy_disk: HTTP 통신에 사용한 Tools Guide 와 기타 메모사항
<br>

> **HTTP 통신에 사용한 Tools = Apache Tomcat®**
<br>

![ddd](https://user-images.githubusercontent.com/79094527/164967057-f6665d1c-e2f7-4c7e-ae42-fd48880cb779.PNG)

<br>
본 폴더에서 연습한 예제들은 Apache Tomcat 을 사용해서 구현함. <br>
버전은 9 버전을 사용했으며, 아래의 사이트에서 다운로드함.<br>

[https://tomcat.apache.org/download-90.cgi](https://tomcat.apache.org/download-90.cgi)
<br>
> 구글에서 검색으로 쉽게 찾아서 다운로드도 가능함. <br>

![us1](https://user-images.githubusercontent.com/79094527/164966313-f5d21d26-5b78-4540-8277-b13e07127fc5.PNG)
![us2](https://user-images.githubusercontent.com/79094527/164966325-b154cd69-0372-43ea-95dc-3390d0cadeef.PNG)

### 아파치 사용중 start.bat 파일이 실행 직후 바로 꺼져버리며 실행이 안될 경우
* **check case1 JAVA_HOME 환경변수 설정 되었는지?** <br>
	* :point_right: 시스템 환경변수에서 자바가 설치된 jdk 폴더의 경로를 환경변수로 설정할 것
* **check case2 check case1이 제대로 되었는데 안되는 경우**
	+ :point_right: cmd창을 켜고 netstat -ano 입력
	+ :point_right: Ctrl + F 눌러서 8080 입력해서 2번째 행의 포트가 8080인 제일 오른쪽 행의 PID 값을 찾음
	+ :point_right: cmd 창에 taskkill /f /pid (2-2에서 찾은 PID, 숫자이고 킬때마다 변함)
	+ :point_right: cmd에서 다시 start.bat 실행
<br>
<br>
<br>
- - -
check case2의 방법은 예제 연습하다가 값 송수신이 안되서 구글링 해본 결과<br>
[https://0jaeyoung.tistory.com/10](https://0jaeyoung.tistory.com/10)   
위의 사이트에서 찾은 해결법이고 이 방법으로 송수신 안되던 문제 해결 했음<br>
- - -
