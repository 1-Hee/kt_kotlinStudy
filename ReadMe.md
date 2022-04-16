### :exclamation: notofications
---
안드로이드 스튜디오에서는 코틀린에서만 'kotlin-extension'이라는 기능을 
지원하여 뷰 바인딩을 편하게 할 수 있도록 지원했다.
그러나, 이 기능을 통해 뷰바인딩을 하면, 
바인딩 된 xml 파일이 제거되었을 때도 코드에서 
검출을 못하는 치명적 단점으로 인해 결국 deprecated 되었는데,
본 레포지토리의 **UI Programming**에서는 **'kotlin-extension'** 이라는 기능을 사용했으나, 
Part2 부터는 이 기능을 사용하지 않고 'kotlin-extension'을 대신하는
뷰바인딩 방법을 사용해서 코드를 작성하였다. :sunny: 

---
> 'kotlin-extension'을 대체하는 방법은 사실 여러가지가 있지만, \n 
> 본 레포지토리에서 default로 채택한 뷰바인딩 방법은 아래의 사이트를 참조했다.

[https://flow9.net/bbs/board.php?bo_table=android&wr_id=27](https://flow9.net/bbs/board.php?bo_table=android&wr_id=27)

사이트에서 자세히 설명되어 있으나, 간략히 소개하자면
- gradle 파일의  android 에서 buildfeatures의 viewBinding 속성을 true로 설정한다
- 메인 액티비티 파일에서 아래와 같이 변수를 생성한다
- onCreate 함수 밑에 setContentView(변수명.root)를 작성한다.
- 기존의 textView =~~~ 라고 쓰던 'kotlin-extension'문법은 변수.textView = ~~ 이런식으로 쓰기만 하면 끝! :baby_chick:
