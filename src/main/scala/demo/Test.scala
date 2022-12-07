package demo

class Base[P] {
  type CC = this.type;

  def apply(f: (CC => P)*): P = ???
};

class DSLElement1[C] extends Base[C] {
  def fixedRate: DslElement0[C] = ???
};

class DslElement0[B] {
  def apply(value: Double): B = ???
};


class Builder {
  def selfff: Builder = this;

  def fixedLeg: DSLElement1[Builder] = ???
};

class Test {
  def test(): Unit = {
    val builder1 = new Builder;
    builder1.selfff.fixedLeg.apply(_.fixedRate.apply(0)); // Fails on 2.13, found C, required: EuropeanSwaptionBuilder0
    builder1.fixedLeg.apply(_.fixedRate.apply(0)); // Fails on 2.13, found C, required: EuropeanSwaptionBuilder0

    // fails on 2.12 as well
    // val temp: FixedIRLeg0[EuropeanSwaptionBuilder0] = builder1.fixedLeg
    // temp.apply(_.fixedRate.apply(0));
  }
}
