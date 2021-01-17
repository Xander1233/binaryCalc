public class binaryFunctions {
    String binary;

    binaryFunctions(String binary) {
        this.binary = binary;
    }

    public String simpleAddition(String _binary) {
        return this.dezToBin((this.binToDez(this.binary)) + (this.binToDez(_binary)));
    }

    public String addition(String _binary) {

        String sum = "";

        boolean requiredExtraOne = false;
        int j = this.binary.length() > _binary.length() ? _binary.length() - 1 : this.binary.length() - 1;
        for (int i = this.binary.length() > _binary.length() ? this.binary.length() - 1 : _binary.length() - 1; i > -1; i--) {
            switch (_binary.length() < this.binary.length() ? this.binary.charAt(i) : _binary.charAt(i)) {
                case '0':
                    switch (this.binary.length() > _binary.length() ? j >= 0 ? _binary.charAt(j) : '5' : j >= 0 ? this.binary.charAt(j) : '5') {
                        case '0':
                            if (requiredExtraOne) {
                                sum = "1" + sum;
                                requiredExtraOne = false;
                            } else {
                                sum = "0" + sum;
                            }
                            break;
                        case '1':
                            if (requiredExtraOne) {
                                sum = "0" + sum;
                            } else {
                                sum = "1" + sum;
                            }
                            break;
                        default:
                            if (requiredExtraOne) {
                                sum = "1" + sum;
                                requiredExtraOne = false;
                            } else {
                                sum = "0" + sum;
                            }
                            break;
                    }
                    break;
                case '1':
                    switch (this.binary.length() > _binary.length() ? j >= 0 ? _binary.charAt(j) : '5' : j >= 0 ? this.binary.charAt(j) : '5') {
                        case '0':
                            if (requiredExtraOne == true) {
                                sum = "0" + sum;
                            } else {
                                sum = "1" + sum;
                            }
                            break;
                        case '1':
                            if (requiredExtraOne) {
                                sum = "1" + sum;
                            } else {
                                sum = "0" + sum;
                                requiredExtraOne = true;
                            }
                            break;
                        default:
                            if (requiredExtraOne) {
                                sum = "0" + sum;
                            } else {
                                sum = "1" + sum;
                            }
                            break;
                    }
                    break;
            }
            j--;
        }
        if (requiredExtraOne) {
            sum = "1" + sum;
        }
        for (int i = 0; sum.charAt(i) != '1'; i++) {
            sum = sum.substring(i + 1, sum.length() - 1);
        }
        return sum;
    }

    public String multiplizieren(String _binary) {
        return this.dezToBin((this.binToDez(this.binary)) * (this.binToDez(_binary)));
    }

    public String dezToBin(int dezimal) {
        String sum = "";
        int old = dezimal;
        while (old > 0) {
            sum = (old % 2) + sum;
            old /= 2;
        }
        return sum;
    }

    public int binToDez(String bin) {
        int sum = 0;
        int potenz = 1;
        for (int i = bin.length() - 1; i >= 0; i--) {
            String c = bin.charAt(i) + "";
            int d = Integer.parseInt(c);
            sum += d * potenz;
            potenz *= 2;
        }
        return sum;
    }

    public String getBinary() {
        return this.binary;
    }
}
