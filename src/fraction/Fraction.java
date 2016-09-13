/**Jinmo Chong's code
 * 
 */

package fraction;

class Fraction {

	private int num;
	private int den;

	public Fraction(int n, int d) {
		if (d == 0) {					// when denominator is 0
			throw new ArithmeticException();
		} else if ((d < 0) && (n > 0)) {
			n *= -1;
			d *= -1;
		} else if ((d < 0) && n < 0) {
			n *= -1;
			d *= -1;
		} else if (n == 0) {
			d = 1;
		}
		this.num = n;
		this.den = d;
		this.normalize();
	}


	public Fraction(int n) {
		this.num = n;
		this.den = 1;
	}

	public Fraction(String s) {
		String [] a = s.split("/");
		int n = Integer.parseInt(a[0]);
		int d = Integer.parseInt(a[1]);
		if (d == 0) {
			throw new ArithmeticException();
		} else if ((d < 0) && (n > 0)) {
			n *= -1;
			d *= -1;
		} else if ((d < 0) && (n < 0)) {	//when d<0 and n<0 make both positives
			n *= -1;
			d *= -1;
		} else if (n == 0) {
			d = 1;
		}
		this.num = n;
		this.den = d;
		this.normalize();
	}


	public Fraction add(Fraction f) {
		int n = (this.num * f.den + this.den * f.num);
		int d = (this.den * f.den);
		Fraction a = new Fraction(n, d);
		return a;
	}

	public Fraction subtract(Fraction f) {
		int n = (this.num * f.den - this.den * f.num);
		int d = (this.den * f.den);
		Fraction a = new Fraction(n, d);
		return a;
	}

	public Fraction multiply(Fraction f) {
		int n = (this.num * f.num);
		int d = (this.den * f.den);
		Fraction a = new Fraction(n, d);
		return a;
	}

	public Fraction divide(Fraction f) {
		if (f.num == 0) {
			throw new ArithmeticException();
		}
		int n = (this.num) * (f.den);
		int d = (this.den) * (f.num);
		Fraction a = new Fraction(n, d);
		return a;
	}

	public Fraction abs() {
		int newnum = Math.abs(this.num);
		int newden = Math.abs(this.den);
		return new Fraction(newnum, newden);
	}

	public Fraction negate() {
		int n = this.num * -1;
		int d = this.den;
		Fraction c = new Fraction(n, d);
		return c;
	}

	public Fraction inverse() {
		int n = this.num;
		int d = this.den;
		if (n == 0) {
			throw new ArithmeticException();
		}
		Fraction c = new Fraction(d, n);
		return c;
	}

	
	private void normalize() {
		//n and d is both negative, becomes positive
		//if only one is negative it will be negative
		int a; 
		int b;
		a = Math.abs(this.num);
		b = Math.abs(this.den);
		int c;
		while (b != 0) {
			c = a % b;
			a = b;
			b = c;
		}				//		a is gcd
		if (this.den < 0 && this.num > 0) {
			this.num *= -1;
			this.den *= -1;
		} else if (this.den < 0 && this.num < 0) {
			this.num *= -1;
			this.den *= -1;
		}
		this.num = this.num / a;
		this.den = this.den / a;	
	}
		

	@Override
	public boolean equals(Object o) {
//if o is not function class, return false
//otherwie, return true
		if (o == this) {
			return true;
		}
		if (!(o instanceof Fraction)) {
			return false;
		} 
		else {
			Fraction f = (Fraction)o;
			return this.num == f.num && this.den == f.den;
//			Fraction f = (Fraction)o;
////			f.den = o.den;
////			f.num = o.num;	
//			return true;
		}
	}

	
	public int hashCode() {
//returns the produce of numerator and denominator
		int a = this.num * this.den;
		return a;
	}

	public int compareTo(Fraction f) {
		if (this.equals(f)) {
			return 0;
		} else {
			int a;
			Fraction b = this.subtract(f);
			a = (b.num > 0) ? 1 : -1;
			return a;
		}
	}

	@Override
	public String toString() {
		int a = this.num;
		int b = this.den;
		if (b == 1) {
		String strI = String.valueOf(this.num);
		return strI;
		} else {
		return a + "/" + b;
		}
	}

}
