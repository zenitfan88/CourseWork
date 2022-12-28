**Отчет по итогам тестирования.**  
Согласно плану автоматизации тестирования сценариев покупки тура было разработано 24 автоматизированных теста. Из которых 2 валидных сценария и 22 негативных.  

*При проведении тестирования 8 тестов завершилось успешно:*   
1.[Успешная покупка тура](https://github.com/zenitfan88/CourseWork/blob/79bda02d4933ac1237e3d52c23768ae7c9a95dfb/src/test/java/ru/netology/test/BuyingTourTest.java#L37).  
2. [Покупка тура при незаполненном поле "Владелец"](https://github.com/zenitfan88/CourseWork/blob/d5fd824ff884515ac3688fcfdd7bcbd1e601bac7/src/test/java/ru/netology/test/BuyingTourTest.java#L223).  
3.[Покупка тура при заполнении поля "CVC/CVV" не валидным количеством символов](https://github.com/zenitfan88/CourseWork/blob/d5fd824ff884515ac3688fcfdd7bcbd1e601bac7/src/test/java/ru/netology/test/BuyingTourTest.java#L327).  
4.[Покупка тура при заполнении поля "Месяц" не валидным количеством символов](https://github.com/zenitfan88/CourseWork/blob/d5fd824ff884515ac3688fcfdd7bcbd1e601bac7/src/test/java/ru/netology/test/BuyingTourTest.java#L158).  
5.[Покупка тура при заполнении поля "Номер карты" не валидным количеством символов](https://github.com/zenitfan88/CourseWork/blob/d5fd824ff884515ac3688fcfdd7bcbd1e601bac7/src/test/java/ru/netology/test/BuyingTourTest.java#L92).  
6.[Покупка тура при заполнении поля "Год", значением ранее текущей даты](https://github.com/zenitfan88/CourseWork/blob/d5fd824ff884515ac3688fcfdd7bcbd1e601bac7/src/test/java/ru/netology/test/BuyingTourTest.java#L210).  
7.[Покупка тура при заполнении поля "Год" не валидным количеством символов](https://github.com/zenitfan88/CourseWork/blob/d5fd824ff884515ac3688fcfdd7bcbd1e601bac7/src/test/java/ru/netology/test/BuyingTourTest.java#L184).  
8.[Покупка тура при использовании номера карты не известной банку](https://github.com/zenitfan88/CourseWork/blob/d5fd824ff884515ac3688fcfdd7bcbd1e601bac7/src/test/java/ru/netology/test/BuyingTourTest.java#L105).  

*16 тестов завершилось с ошибкой:*  
1.[Отказ банка при покупке тура](https://github.com/zenitfan88/CourseWork/blob/14a4d770710dd6d97206243e31b3faef4da20c64/src/test/java/ru/netology/test/BuyingTourTest.java#L47).  
[Баг репорт](https://github.com/zenitfan88/CourseWork/issues/2).   
2.[Покупка тура при заполнении поля "Номер карты" нулями](https://github.com/zenitfan88/CourseWork/blob/14a4d770710dd6d97206243e31b3faef4da20c64/src/test/java/ru/netology/test/BuyingTourTest.java#L64).  
[Баг репорт](https://github.com/zenitfan88/CourseWork/issues/4).   
3.[Покупка тура при незаполненном поле "Номер карты](https://github.com/zenitfan88/CourseWork/blob/14a4d770710dd6d97206243e31b3faef4da20c64/src/test/java/ru/netology/test/BuyingTourTest.java#L57).  
[Баг репорт](https://github.com/zenitfan88/CourseWork/issues/15).  
4. [Покупка тура при заполнении поля "Месяц" значением, превышающим валидное](https://github.com/zenitfan88/CourseWork/blob/14a4d770710dd6d97206243e31b3faef4da20c64/src/test/java/ru/netology/test/BuyingTourTest.java#L104).  
[Баг репорт](https://github.com/zenitfan88/CourseWork/issues/17).  
5.[Покупка тура при незаполненном поле "Месяц"](https://github.com/zenitfan88/CourseWork/blob/14a4d770710dd6d97206243e31b3faef4da20c64/src/test/java/ru/netology/test/BuyingTourTest.java#L88).  
[Баг репорт](https://github.com/zenitfan88/CourseWork/issues/14).  
6.[Покупка тура при заполнении поля "Месяц" нулями](https://github.com/zenitfan88/CourseWork/blob/14a4d770710dd6d97206243e31b3faef4da20c64/src/test/java/ru/netology/test/BuyingTourTest.java#L96).  
[Баг репорт](https://github.com/zenitfan88/CourseWork/issues/3).   
7.[Покупка тура при заполнении поля "Год" нулями](https://github.com/zenitfan88/CourseWork/blob/14a4d770710dd6d97206243e31b3faef4da20c64/src/test/java/ru/netology/test/BuyingTourTest.java#L136).  
[Баг репорт](https://github.com/zenitfan88/CourseWork/issues/18).   
8.[Покупка тура при незаполненном поле "Год"](https://github.com/zenitfan88/CourseWork/blob/14a4d770710dd6d97206243e31b3faef4da20c64/src/test/java/ru/netology/test/BuyingTourTest.java#L120).  
[Баг репорт](https://github.com/zenitfan88/CourseWork/issues/16).  
9.[Покупка тура при заполнении поля "Владелец" латиницей с количеством букв более 50](https://github.com/zenitfan88/CourseWork/blob/14a4d770710dd6d97206243e31b3faef4da20c64/src/test/java/ru/netology/test/BuyingTourTest.java#L200).  
[Баг репорт](https://github.com/zenitfan88/CourseWork/issues/10).  
10.[Покупка тура при заполнении поля "Владелец" латиницей, цифрами и специальными символами](https://github.com/zenitfan88/CourseWork/blob/14a4d770710dd6d97206243e31b3faef4da20c64/src/test/java/ru/netology/test/BuyingTourTest.java#L192).  
[Баг репорт](https://github.com/zenitfan88/CourseWork/issues/9).  
11.[Покупка тура при заполнении поля "Владелец" цифрами](https://github.com/zenitfan88/CourseWork/blob/14a4d770710dd6d97206243e31b3faef4da20c64/src/test/java/ru/netology/test/BuyingTourTest.java#L168).  
[Баг репорт](https://github.com/zenitfan88/CourseWork/issues/7).  
12.[Покупка тура при заполнении поля "Владелец" кириллицей](https://github.com/zenitfan88/CourseWork/blob/14a4d770710dd6d97206243e31b3faef4da20c64/src/test/java/ru/netology/test/BuyingTourTest.java#L160).  
[Баг репорт](https://github.com/zenitfan88/CourseWork/issues/5).  
13.[Покупка тура при заполнении поля "Владелец" кириллицей, цифрами и специальными символами](https://github.com/zenitfan88/CourseWork/blob/14a4d770710dd6d97206243e31b3faef4da20c64/src/test/java/ru/netology/test/BuyingTourTest.java#L184).  
[Баг репорт](https://github.com/zenitfan88/CourseWork/issues/1).  
14.[Покупка тура при заполнении поля "Владелец" специальными символами](https://github.com/zenitfan88/CourseWork/blob/14a4d770710dd6d97206243e31b3faef4da20c64/src/test/java/ru/netology/test/BuyingTourTest.java#L176).  
[Баг репорт](https://github.com/zenitfan88/CourseWork/issues/11).  
15.[Покупка тура при незаполненном поле "CVC/CVV"](https://github.com/zenitfan88/CourseWork/blob/14a4d770710dd6d97206243e31b3faef4da20c64/src/test/java/ru/netology/test/BuyingTourTest.java#L208).  
[Баг репорт №1](https://github.com/zenitfan88/CourseWork/issues/13). [Баг репорт №2](https://github.com/zenitfan88/CourseWork/issues/6).  
16.[Покупка тура при заполнении поля "CVC/CVV" нулями](https://github.com/zenitfan88/CourseWork/blob/14a4d770710dd6d97206243e31b3faef4da20c64/src/test/java/ru/netology/test/BuyingTourTest.java#L224).  
[Баг репорт](https://github.com/zenitfan88/CourseWork/issues/12).  

![AllureReport](https://user-images.githubusercontent.com/105923354/209808185-1b8ceec7-29fa-40e5-af7e-fc3c2bc0b5f8.png)

Процентное соотношение успешных и неуспешных тестов составило: 33% к 66% соответственно.  
3 обнаруженных дефекта имеют уровень серьезности "Critical", 8 дефектов имеют уровень серьезности "Major", 6 дефектов имеют уровень серьезности "Minor".

**Общие рекомендации:**  
- Необходимо срочное исправление дефектов с уровнем серьезности "Critical", влияющих на работоспособность формы покупки тура;
- Доработка вывода корректных сообщений об ошибках при заполнении полей невалидными значениями;
- Ограничение на введение в поле "Владелец" любых символов, кроме латинских букв и пробелов.
