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
