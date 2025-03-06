public class Patterns {
    public void pattern1(int n) {
        //*****
        //*****
        //*****
        //*****
        //*****

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public void pattern2(int n) {
        //*
        //**
        //***
        //****
        //*****
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void pattern3(int n) {
        //1
        //22
        //333
        //4444
        //55555
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(i + 1);
            }
            System.out.println();
        }
    }

    public void pattern4(int n) {
        //1
        //12
        //123
        //1234
        //12345
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }
    }

    public void pattern5(int n) {
        //*****
        //****
        //***
        //**
        //*
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void pattern6(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(j + 1);
            }
            System.out.println();
        }
    }

    public void pattern7(int n) {
        //     *
        //    ***
        //   *****
        //  *******
        // *********
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void pattern8(int n) {
        // *********
        //  *******
        //   *****
        //    ***
        //     *
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * n - (2 * i + 1); j++) {
                System.out.print("*");
            }
            for (int j = 0; j < n; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void pattern9(int n) {
        //    *
        //   ***
        //  *****
        // *******
        //*********
        //*********
        // *******
        //  *****
        //   ***
        //    *
        pattern7(n);
        pattern8(n);
    }

    public void pattern10(int n) {
        for (int i = 1; i <= 2 * n - 1; i++) {
            int stars = i;
            if (i > n)
                stars = 2 * n - i;
            for (int j = 1; j <= stars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    public void pattern11(int n) {
        //1
        //01
        //101
        //0101
        //10101
        int start = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                start = 1;
            else
                start = 0;
            for (int j = 0; j <= i; j++) {
                System.out.print(start);
                start = 1 - start;
            }
            System.out.println();
        }

    }

    public void pattern12(int n) {
        //1      1
        //12    21
        //123  321
        //12344321
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }

    }

    public void pattern13(int n) {
        //1
        //2 3
        //4 5 6
        //7 8 9 10
        //11 12 13 14 15
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
        }

    }

    public void pattern14(int n) {
        //A
        //AB
        //ABC
        //ABCD
        //ABCDE
        for (int i = 0; i < n; i++) {
            char print = 'A';
            for (int j = 0; j <= i; j++) {
                System.out.print(print);
                print += 1;
            }
            System.out.println();
        }

    }

    public void pattern15(int n) {
        //ABCDE
        //ABCD
        //ABC
        //AB
        //A
        for (int i = n; i > 0; i--) {
            char print = 'A';
            for (int j = 0; j < i; j++) {
                System.out.print(print);
                print += 1;
            }
            System.out.println();
        }

    }

    public void pattern16(int n) {
        char print = 'A';
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(print);
            }
            print += 1;
            System.out.println();
        }

    }

    public void pattern17(int n) {
        //    A
        //   ABA
        //  ABCBA
        // ABCDCBA
        //ABCDEDCBA
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            char print = 'A';
            int breakboint = (2 * i + 1) / 2;
            for (int j = 1; j <= 2 * i + 1; j++) {
                System.out.print(print);
                if (j <= breakboint)
                    print++;
                else
                    print--;
            }
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }

    }

    public void pattern18(int n) {
        //E
        //DE
        //CDE
        //BCDE
        //ABCDE
        for (int i = 0; i < n; i++) {
            char print = (char) ('A' + n - i - 1);
            for (int j = 0; j <= i; j++) {
                System.out.print(print);
                print += 1;
            }
            System.out.println();
        }

    }

    public void pattern19(int n) {
        //**********
        //****  ****
        //***    ***
        //**      **
        //*        *
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");

            }
            for (int j = 0; j < 2 * i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");

            }
            System.out.println();
        }

    }

    public void pattern20(int n) {
        //*****
        //*   *
        //*   *
        //*   *
        //*****
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == n - 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

    }

    public void pattern21(int n) {
        //5 5 5 5 5 5 5 5 5
        //5 4 4 4 4 4 4 4 5
        //5 4 3 3 3 3 3 4 5
        //5 4 3 2 2 2 3 4 5
        //5 4 3 2 1 2 3 4 5
        //5 4 3 2 2 2 3 4 5
        //5 4 3 3 3 3 3 4 5
        //5 4 4 4 4 4 4 4 5
        //5 5 5 5 5 5 5 5 5

        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                int top = i;
                int left = j;
                int bottom = 2 * n - 2 - i;
                int right = 2 * n - 2 - j;
                System.out.print(n - Math.min(Math.min(top, bottom), Math.min(left, right)) + " ");
            }
            System.out.println();
        }
    }


}
