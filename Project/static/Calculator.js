if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'Calculator'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'Calculator'.");
}var Calculator = function (_, Kotlin) {
  'use strict';
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  var listOf = Kotlin.kotlin.collections.listOf_i5x0yv$;
  var contains = Kotlin.kotlin.text.contains_li3zpu$;
  var Pair = Kotlin.kotlin.Pair;
  var listOf_0 = Kotlin.kotlin.collections.listOf_mh5how$;
  var toString = Kotlin.toString;
  var numberToInt = Kotlin.numberToInt;
  var plus = Kotlin.kotlin.collections.plus_qloxvw$;
  var equals = Kotlin.equals;
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var emptyList = Kotlin.kotlin.collections.emptyList_287e2$;
  var ArrayList_init = Kotlin.kotlin.collections.ArrayList_init_287e2$;
  var checkIndexOverflow = Kotlin.kotlin.collections.checkIndexOverflow_za3lpa$;
  function main(object1, object2) {
    println(object1);
  }
  function mainTest() {
    var tmp$, tmp$_0, tmp$_1, tmp$_2;
    var ma = new modFlo(listOf(['F', 'G', 'W']), listOf([2.0, 0.5, 2.0]));
    var mb = new modFlo(listOf(['N', 'G', 'W']), listOf([0.5, 2.0, 2.0]));
    var mc = new modFlo(listOf(['N', 'F', 'W']), listOf([1.0, 1.0, 1.0]));
    var t1 = new type('N', ma);
    var t3 = new type('W', mb);
    var t2 = new type('F', mc);
    var t4 = duoType(t1, t1);
    var t5 = duoType(t1, t3);
    var t6 = duoType(t2, t3);
    var ataqF = new ataque('F', 100, true);
    var ataqG = new ataque('G', 100, true);
    var ataqW = new ataque('W', 100, false);
    var ataqN = new ataque('N', 100, false);
    var poke1 = new pokemon(t5, 50, 50, 50, 50, 100);
    var poke2 = new pokemon(t4, 50, 50, 50, 50, 50);
    var poke3 = new pokemon(t6, 50, 50, 50, 50, 10);
    var fator1 = gerarFator('gutsburn');
    var fator2 = gerarFator('');
    var fator3 = gerarFator('burn');
    var fator4 = gerarFator('wonder');
    var listA = listOf([ataqF, ataqG, ataqW, ataqN]);
    var listP = listOf([poke1, poke2, poke3]);
    var listF = listOf([fator1, fator2, fator3, fator4]);
    tmp$ = listA.iterator();
    while (tmp$.hasNext()) {
      var a = tmp$.next();
      tmp$_0 = listP.iterator();
      while (tmp$_0.hasNext()) {
        var p1 = tmp$_0.next();
        tmp$_1 = listP.iterator();
        while (tmp$_1.hasNext()) {
          var p2 = tmp$_1.next();
          tmp$_2 = listF.iterator();
          while (tmp$_2.hasNext()) {
            var f = tmp$_2.next();
            println(danoT(a, p1, p2, f));
          }
        }
      }
    }
  }
  function gerarFator(lista) {
    var tmp$, tmp$_0;
    if (contains(lista, 'guts')) {
      if (contains(lista, 'burn') || contains(lista, 'poison')) {
        tmp$ = new Pair('guts', 2.0);
      } else {
        tmp$ = new Pair('guts', 1.0);
      }
    } else {
      if (contains(lista, 'burn')) {
        tmp$ = new Pair('burn', 0.5);
      } else {
        tmp$ = new Pair('guts', 1.0);
      }
    }
    var x1 = tmp$;
    if (contains(lista, 'wonder')) {
      tmp$_0 = new modFlo(listOf_0('wonder'), listOf_0(1.0));
    } else {
      tmp$_0 = new modFlo(emptyList(), emptyList());
    }
    var f = tmp$_0;
    return f.plus_dvhx5k$(x1);
  }
  function danoT(ataq, pokeA, pokeD, fatores) {
    var tmp$;
    var w = fatores.contains_61zpoe$('wonder');
    if (w) {
      tmp$ = pokeD.wD();
    } else {
      tmp$ = pokeD;
    }
    var pDef = tmp$;
    var r = calculos(ataq, pokeA, pDef, w);
    var m = fatores.mult1();
    var crit = 1.5;
    var rf = m * r;
    println(ataq.tipo + '-' + pokeA.t.nome + '-' + pokeD.t.nome + '-' + toString(fatores.nome));
    return listOf([numberToInt(rf * 0.85), numberToInt(rf), numberToInt(rf * 0.85 * crit), numberToInt(rf * crit)]);
  }
  function calculos(ataq, pokeA, pokeD, wonder) {
    var tmp$, tmp$_0, tmp$_1, tmp$_2;
    if (ataq.special) {
      tmp$ = pokeA.spAtk;
    } else {
      tmp$ = pokeA.atk;
    }
    var a = tmp$;
    if (ataq.special) {
      tmp$_0 = pokeD.spDef;
    } else {
      tmp$_0 = pokeD.def;
    }
    var d = tmp$_0;
    var l = pokeA.level * 2.0 / 5 + 2;
    var power = ataq.power;
    var p2 = power * l * a / d / 50 + 2;
    if (pokeA.t.vTipo_61zpoe$(ataq.tipo)) {
      tmp$_1 = 1.5;
    } else {
      tmp$_1 = 1.0;
    }
    var stab = tmp$_1;
    var m = pokeD.t.get_61zpoe$(ataq.tipo);
    if (wonder && m <= 1.0) {
      tmp$_2 = 0.0;
    } else {
      tmp$_2 = pokeD.t.get_61zpoe$(ataq.tipo);
    }
    var fr = tmp$_2;
    var result = fr * stab * p2;
    return numberToInt(result);
  }
  function modFlo(nome, valor) {
    this.nome = nome;
    this.valor = valor;
  }
  modFlo.prototype.times_dvhx5k$ = function (n) {
    var nT = n.component1()
    , mD = n.component2();
    var i = this.indexOf_61zpoe$(nT);
    var v = this.get_za3lpa$(i);
    if (v === 0.0) {
      return this;
    }var nM = mD * this.get_za3lpa$(i);
    var novo = this.minus_61zpoe$(nT);
    if (nM === 1.0) {
      return novo;
    } else {
      return novo.plus_dvhx5k$(new Pair(nT, nM));
    }
  };
  modFlo.prototype.plus_dvhx5k$ = function (other) {
    var nT = other.component1()
    , nM = other.component2();
    if (this.nome.contains_11rb$(nT) || nM === 1.0) {
      return this;
    }return new modFlo(plus(this.nome, nT), plus(this.valor, nM));
  };
  modFlo.prototype.minus_61zpoe$ = function (s) {
    if (this.size() === 0) {
      return this;
    }if (!this.nome.contains_11rb$(s)) {
      return this;
    }var x = this.indexOf_61zpoe$(s);
    var $receiver = this.nome;
    var destination = ArrayList_init();
    var tmp$;
    tmp$ = $receiver.iterator();
    while (tmp$.hasNext()) {
      var element = tmp$.next();
      if (!equals(element, s))
        destination.add_11rb$(element);
    }
    var $receiver_0 = this.valor;
    var destination_0 = ArrayList_init();
    var tmp$_0, tmp$_0_0;
    var index = 0;
    tmp$_0 = $receiver_0.iterator();
    while (tmp$_0.hasNext()) {
      var item = tmp$_0.next();
      if (checkIndexOverflow((tmp$_0_0 = index, index = tmp$_0_0 + 1 | 0, tmp$_0_0)) !== x)
        destination_0.add_11rb$(item);
    }
    return new modFlo(destination, destination_0);
  };
  modFlo.prototype.get_za3lpa$ = function (i) {
    var x = this.size();
    if (x === 0) {
      return 1.0;
    } else if (x <= i) {
      return 1.0;
    }return this.valor.get_za3lpa$(i);
  };
  modFlo.prototype.get_61zpoe$ = function (i) {
    var x = this.indexOf_61zpoe$(i);
    if (x < 0) {
      return 1.0;
    }return this.valor.get_za3lpa$(x);
  };
  modFlo.prototype.indexOf_61zpoe$ = function (s) {
    return this.nome.indexOf_11rb$(s);
  };
  modFlo.prototype.wonderGuard_za3lpa$ = function (i) {
    if (i >= this.size()) {
      return this;
    } else if (this.get_za3lpa$(i) <= 1.0) {
      var s = this.getS_za3lpa$(i);
      var x = this.get_za3lpa$(i);
      println(x.toString() + ' ' + s + '  WF');
      var novo = this.minus_61zpoe$(this.getS_za3lpa$(i));
      return novo.wonderGuard_za3lpa$(i);
    } else {
      var s_0 = this.getS_za3lpa$(i);
      var x_0 = this.get_za3lpa$(i);
      println(x_0.toString() + ' ' + s_0 + '  WGr');
      return this.wonderGuard_za3lpa$(i + 1 | 0);
    }
  };
  modFlo.prototype.contains_61zpoe$ = function (s) {
    return this.nome.contains_11rb$(s);
  };
  modFlo.prototype.getS_za3lpa$ = function (i) {
    return this.nome.get_za3lpa$(i);
  };
  modFlo.prototype.getP_za3lpa$ = function (i) {
    return new Pair(this.getS_za3lpa$(i), this.get_za3lpa$(i));
  };
  modFlo.prototype.size = function () {
    return this.nome.size;
  };
  modFlo.prototype.mult1 = function () {
    if (this.size() === 0) {
      return 1.0;
    } else {
      return this.mult_za3lpa$(0);
    }
  };
  modFlo.prototype.mult_za3lpa$ = function (i) {
    if (i >= this.size()) {
      return 1.0;
    } else {
      return this.get_za3lpa$(i) * this.mult_za3lpa$(i + 1 | 0);
    }
  };
  modFlo.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'modFlo',
    interfaces: []
  };
  function pokemon(t, atk, spAtk, def, spDef, level) {
    this.t = t;
    this.atk = atk;
    this.spAtk = spAtk;
    this.def = def;
    this.spDef = spDef;
    this.level = level;
  }
  pokemon.prototype.wD = function () {
    var nT = this.t.modifica.wonderGuard_za3lpa$(0);
    return new pokemon(new type(this.t.nome, nT), this.atk, this.spAtk, this.def, this.spDef, this.level);
  };
  pokemon.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'pokemon',
    interfaces: []
  };
  function type(nome, modifica) {
    this.nome = nome;
    this.modifica = modifica;
  }
  type.prototype.vTipo_61zpoe$ = function (s) {
    return contains(this.nome, s);
  };
  type.prototype.same_24myi$ = function (t) {
    return equals(this.nome, t.nome);
  };
  type.prototype.get_61zpoe$ = function (i) {
    return this.modifica.get_61zpoe$(i);
  };
  type.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'type',
    interfaces: []
  };
  function ataque(tipo, power, special) {
    this.tipo = tipo;
    this.power = power;
    this.special = special;
  }
  ataque.$metadata$ = {
    kind: Kind_CLASS,
    simpleName: 'ataque',
    interfaces: []
  };
  function duoType(tp1, tp2) {
    if (equals(tp1, tp2)) {
      return tp1;
    }var n1 = tp1.nome;
    var n2 = tp2.nome;
    return new type(n1 + n2, combinar(tp1.modifica, tp2.modifica, 0));
  }
  function combinar(a1, a2, n) {
    if (n >= a2.size()) {
      return a1;
    } else if (a1.contains_61zpoe$(a2.getS_za3lpa$(n))) {
      return combinar(a1.times_dvhx5k$(a2.getP_za3lpa$(n)), a2, n + 1 | 0);
    } else {
      return combinar(a1.plus_dvhx5k$(a2.getP_za3lpa$(n)), a2, n + 1 | 0);
    }
  }
  _.main = main;
  _.mainTest = mainTest;
  _.gerarFator = gerarFator;
  _.danoT = danoT;
  _.calculos = calculos;
  _.modFlo = modFlo;
  _.pokemon = pokemon;
  _.type = type;
  _.ataque = ataque;
  _.duoType = duoType;
  _.combinar = combinar;
  Kotlin.defineModule('Calculator', _);
  return _;
}(typeof Calculator === 'undefined' ? {} : Calculator, kotlin);
