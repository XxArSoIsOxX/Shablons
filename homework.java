package Modul9;


abstract class Beverage {
    public abstract double cost();    
    public abstract String getDescription();
}


abstract class BeverageDecorator extends Beverage {
    protected Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    
    @Override
    public double cost() {
        return beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription();
    }
}


class Coffee extends Beverage {
    @Override
    public double cost() {
        return 2.50;
    }

    @Override
    public String getDescription() {
        return "Coffee";
    }
}

class Latte extends Beverage {
    @Override
    public double cost() {
        return 4.0;
    }

    @Override
    public String getDescription() {
        return "Latte";
    }
}


class Mocha extends Beverage {
    @Override
    public double cost() {
        return 3.50;
    }

    @Override
    public String getDescription() {
        return "Mocha";
    }
}

//Coffe
class MilkDecorator extends BeverageDecorator {
    public MilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return super.cost() + 0.50; 
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }
}


class SugarDecorator extends BeverageDecorator {
    public SugarDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return super.cost() + 0.10; 
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }
}


class WhippedCream extends BeverageDecorator {
    public WhippedCream(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return super.cost() + 0.80; 
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", WhippedCream"; 
    }
}

//Latte
class LatteCaramelDecorator extends BeverageDecorator {
    public LatteCaramelDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return super.cost() + 1.0; 
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Caramel";
    }
}

class LatteKakosDecorator extends BeverageDecorator {
    public LatteKakosDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return super.cost() + 0.90; 
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Kakos";
    }
}


//Mocha
class MachoMilkDecorator extends BeverageDecorator {
    public MachoMilkDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return super.cost() + 0.50; 
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }
}

class MachoChocolateDecorator extends BeverageDecorator {
    public MachoChocolateDecorator(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return super.cost() + 1.50; 
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Chocolate";
    }
}


public class homework {
    public static void main(String[] args) {
        Beverage coffee = new Coffee();
        Beverage latte = new Latte();
        Beverage macho = new Mocha();

        Beverage coffeeWithMilk = new MilkDecorator(coffee);
        Beverage latteWithCaramel = new LatteCaramelDecorator(latte);
        Beverage machoWithChocolate = new MachoChocolateDecorator(macho);   

        System.out.println(coffeeWithMilk.getDescription());
        System.out.println("Стоймость: $" + coffeeWithMilk.cost());

        System.out.println(latteWithCaramel.getDescription());
        System.out.println("Стоймость: $" + latteWithCaramel.cost());

        System.out.println(machoWithChocolate.getDescription());
        System.out.println("Стоймость: $" + machoWithChocolate.cost());
    }
}
