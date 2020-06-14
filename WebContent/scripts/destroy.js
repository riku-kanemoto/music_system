/**
 *
 */
document.querySelector("#destroy").onclick=function destroyConfilm(){
  if(confirm("本当に削除してよろしいですか？")) {
    document.forms[1].submit();
  }
}