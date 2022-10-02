
// ajaxSubmit
function ajaxSubmit(url, obj) {

  // url에 따라 구분짓기
  const urlType = ['list', 'listAll', 'search', 'searchAll', 'view'];
  let method = 'POST';

  urlType.forEach(function(ele){
    if(url.indexOf(ele) > 0) {
      method = 'GET';
      return false;
    }
  });

  /*
  * ajax 프로그래밍에 사용하기 위해 사용
  * 서버와 상호작용하기 위해 사용
  *
  * setRequestHeader : http 요청헤더 값 설정, send()보단 앞에, open()보단 뒤에 작성
  * */
  let xmlHttpRequest = new XMLHttpRequest();
  xmlHttpRequest.open(method, url, true);
  xmlHttpRequest.setRequestHeader('Content-type', 'application/json; charset=UTF-8');
  xmlHttpRequest.send(obj);

  xmlHttpRequest.onreadystatechange = function() {
    // success
    if(xmlHttpRequest.readyState === 4) {
      const urlPath = document.location.pathname.replace('/', '').split('/');
      const path = urlPath[0];

      // 200
      if(xmlHttpRequest.status === 200) {
        const data = JSON.parse(xmlHttpRequest.responseText);
        location.href = '../' + path + '/view/' + data.boardId;
      }

    } else {
      // readyState로 어디 부분이 문제인지 파악하기
      /*
      * 0: Client has been created. open() not called yet.
      * 1: open() has been called.
      * 2: send() has been called, and headers and status are available.
      * 3: Downloading; responseText holds partial data.
      * 4: The operation is complete
      * */
      console.log(xmlHttpRequest.readyState);
    }
  }
}

function isNull(str) {
  return (str == null);
}

