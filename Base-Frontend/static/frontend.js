if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'frontend'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'frontend'.");
}var frontend = function (_, Kotlin) {
  'use strict';
  var Unit = Kotlin.kotlin.Unit;
  function limpar() {
    var elem = document.getElementById('p1');
    if (elem != null) {
      elem.innerHTML = '';
    }}
  function botaoClicado(nome) {
    var elem = document.getElementById('p1');
    if (elem != null) {
      elem.innerHTML = elem.innerHTML + ('\n' + '            <br> <font color=' + '"' + nome + '"' + '>Este texto foi inserido pelo programa Kotlin ' + '\n' + '            ao pressionar o botao ' + nome + '<\/font>' + '\n' + '            <button onclick=' + '"' + "frontend.botaoClicado('yellow')" + '"' + '>Nao aperte esse botao<\/button>' + '\n' + '            ');
    }}
  // function main$lambda() {
  //   var elem = document.getElementById('p1');
  //   if (elem != null) {
  //     elem.innerHTML = elem.innerHTML + '<br> Tick\n';
  //   }return Unit;
  // }
  function main() {
    for (var c = 1; c <= 100; c++)
      window.setInterval(main$lambda, 1000);
  }
  _.botaoLimpar = limpar;
  _.botaoClicado = botaoClicado;
  _.main = main;
  main();
  Kotlin.defineModule('frontend', _);
  return _;
}(typeof frontend === 'undefined' ? {} : frontend, kotlin);
