# SE-Lab-5
## سوال اول
برنامه را با ورودیهای 4 و 7 و 9 اجرا میکنیم و میفهمیم که تابع `temp` بیشترین زمان اجرا را دارد:

![image](https://github.com/Software-Engineering-Laboratory-Sharif/SE-Lab-5/assets/59170401/982dc2f1-05d4-4905-9d03-224fda3d74a3)

همچنین میفهمیم که تابع `add` بیشترین زمان اجرا را گرفته که به دلیل داینامیک بودن 'ArrayList' زیاد طول می‌کشد. همچنین به مشکل کمبود حافظه هم خوردیم.

![image](https://github.com/Software-Engineering-Laboratory-Sharif/SE-Lab-5/assets/59170401/e231e8db-9166-4a7a-8e69-0364899507ae)

بجای آنکه از آرایه داینامیک استفاده کنیم، از آرایه با اندازه ثابت استفاده می‌کنیم. چون اندازه آرایه‌ای که در این تابع وجود دارد ثابت است.

```java
int[] a = new int[10000 * 20000];
int index = 0;
for (int i = 0; i < 10000; i++)
{
    for (int j = 0; j < 20000; j++) {
        a[index] = i + j;
        index++;
    }
}
```

حال میبینیم که میزان استفاده CPU و زمان اجرا خیلی بهتر شده است و اینکه به مشکل هم نخوردیم و برنامه با موفقیت اجرا می‌شود.

![image](https://github.com/Software-Engineering-Laboratory-Sharif/SE-Lab-5/assets/59170401/6bec56c6-b8c6-4a23-be54-4e324a1958c4)
![image](https://github.com/Software-Engineering-Laboratory-Sharif/SE-Lab-5/assets/59170401/e1d586be-3593-42b9-b141-d37b0b5f18ce)

## سوال دوم
برای این سوال کدی را نوشتیم که اعداد اول از 1 تا 10000 را پیدا کند. کد زیر کد اولیه است:

```java
public class PrimeCalculator {
    public static void main(String[] args) {
        final int UPPER_LIMIT = 10000;
        printPrimeNumbers(UPPER_LIMIT);
    }

    private static void printPrimeNumbers(int upperLimit) {
        System.out.println("First prime numbers up to " + upperLimit + ":");
        for (int number = 2; number <= upperLimit; number++) {
            if (checkPrime(number)) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }

    private static boolean checkPrime(int num) {
        if (num <= 1) return false;

        for (int i = 2; i < num; i++) {
            if (multipleFound(num, i)) return false;
        }
        return true;
    }

    private static boolean multipleFound(int num, int factor) {
        for (int j = 1; j <= factor; j++) {
            if (factor * j == num) {
                return true;
            }
        }
        return false;
    }
}
```
شکلهای زیر عملکرد کد را نشان می‌دهند:
![image](https://github.com/Software-Engineering-Laboratory-Sharif/SE-Lab-5/assets/59170401/85ce9c53-d7c2-4518-9e4a-82797053afbc)
![image](https://github.com/Software-Engineering-Laboratory-Sharif/SE-Lab-5/assets/59170401/45beab19-933f-4bd9-8bba-9bf59678c40b)
![image](https://github.com/Software-Engineering-Laboratory-Sharif/SE-Lab-5/assets/59170401/e553803b-78bb-4c0f-a49b-dc2eafa93906)

حال کد را به این شکل بهینه می‌کنیم که که فقط اعداد فرد را بررسی کند و اینکه تا جذر آن عدد هم بررسی می‌کنیم آیا عدد مورد نظر ما بر هیچکدام بخش پذیر است یا نه:
```java
public class PrimeCalculator {
    public static void main(String[] args) {
        final int UPPER_LIMIT = 10000; // Use a constant for the limit
        printPrimeNumbers(UPPER_LIMIT);
    }

    private static void printPrimeNumbers(int upperLimit) {
        System.out.println("Prime numbers up to " + upperLimit + ":");
        for (int number = 2; number <= upperLimit; number++) {
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }
        System.out.println(); // Ensures the output ends with a newline
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true; // 2 is the only even prime number
        if (num % 2 == 0) return false; // Exclude all even numbers greater than 2

        for (int i = 3; i * i <= num; i += 2) { // Only test odd factors
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
```
مجدد کد را اجرا می‌کنیم و درمی‌یابیم که در میزان مصرف CPU کاهش قابل توجهی داشتیم.
![image](https://github.com/Software-Engineering-Laboratory-Sharif/SE-Lab-5/assets/59170401/5ae32a1e-1570-4688-a767-8c1da2700f67)
![image](https://github.com/Software-Engineering-Laboratory-Sharif/SE-Lab-5/assets/59170401/5df51b7b-a26a-4f7e-80ff-28b46acc2fa0)
![image](https://github.com/Software-Engineering-Laboratory-Sharif/SE-Lab-5/assets/59170401/dc71f96a-7c6d-4098-a4b3-a178dd11cf38)

