### :exclamation: notofications
---
DrawerLayout은 안드로이드에서 제공하는 로그인창 레이아웃인데, <br>
원래는 개발자가 일일히 개발해야 했던 것을 구글에서 쉽고 간편하게 쓸 수 있도록 만들어서 제공해준다. <br>
*아래의 사진 참조* <br>

<br>
그래서, 내부에 굉장히 많은 파일들이 존재하고 상호간의 관계를 다 따지자면 굉장히 복잡하다 <br>
하나부터 열까지 다 뜯어 고쳐서 만들거 아니면 대표적인 파일 세가지를 기억하면 된다. <br>

1. 안드로이드 res 파일의 navigation 폴더의 **mobile_navigation.xml**
2.  안드로이드 res 파일의 menu 폴더 **activity_main_drawer.xml**
3. MainActivity의  **appBarConfiguration부터 시작하는 Contoller 부분**

안드로이드 스튜디오에서 간편히 사용하는 법은 위에서 번호매김한 순서와 같다. <br>
이에 대해 자세히 서술하자면, <br>

먼저, 추가하고 싶은 **fragment 파일**을 생성하고, 내부 코드를 원하는 만큼 작성하여 완성시킨다. <br>
그다음 **mobile_navigation.xml** 파일에 생성한 frament를 형식에 맞추어 작성하고, <br>
그다음 <U>**activity_main_drawer 에 mobile_navigation.xml 파일에서 사용한 id와 토씨하나 틀리지 않게 100% 같은 아이디로 형식에 맞춰 추가한다**</U> <br>
*(여기서 아이디 틀리면 무조건 고장나거나 팅김)* <br>
마지막으로, Mainactivity에서 **appBarConfiguration의 setOf()의 매개변수로 새로 생성한 fragment의 아이디값을 추가**하면 끝 😋 <br>

기존에 안드로이드 스튜디오에서 만들어진 파일도 당연히 편집 가능하고, 기본으로 추가된 floating Button도 원한다면 제거해도 문제는 없다. <br>
단, 여기서 무엇보다 중요한 것은 <U> **activity_main_drawer 와 mobile_navigation.xml 와 짝짓는 frament의 id 값은 토씨하나 틀려서는 안된다는 것.**<U/> <br>

이 점만 주의해서 사용하면 굳이 복잡하게 코드짜서 A to Z로 구현할 것 없이 사용 가능하다.

---

