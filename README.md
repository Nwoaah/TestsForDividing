# TestsForDividing
По проетку:
Сделал кучу тестов, уверен, что, что-то не покрыл, а что-то покрыл даже с лихвой(думаю куча есть ненужных тестов) 
К сожалению не было времени разбираться, поэтому оставлю на данный момент так.
Основная проблема приложения: округление до 2 знака(как я понял после запятой имелось ввиду).
Так же с делением на 0, мне не понравились значения выдаваемые программой, поэтому в scv написал строку ожидания exception,
надеюсь это не столь важно.
Так же, на вывод программа дает только 6 значное число, или нечто, помноженное на 10 в степени. Не стал бороться с выводом рода 12e+10,
по причине так же нехватки времени, да и не уверен, что на данном этапе это важно.

Что касается описания тестов - не писал у каждого что и почему, они скорее сгруппированы, надеюсь все понятно. 
Описание тестов находится в TestsDescription.txt
Если что, готов отвтетить на вопросы.
Тесты хранятся в TestsSources.csv, реализовать решил как @ParameterizedTest
+ Добавил негативные тест кейсы, постарался не повторяться, основная идея - приложение выдает 1(вероятно это код ошибки, хотя может и просто 1)
Если не может вытащить число сразу, то есть начинается число не с одного - или не с цифр, то идет ошибка,
если одно число до пробела, то оно идет в ответ, если после то 1.

Было требования по отчету, считаю что отчет junit очень даже неплох, если запускать напрямую из идеи.
Что касается запуска из командной строки:
У меня на windows из командной строки, запускалось вот так, перейти в каталог, где лежит junitArgsForConsoleLauncher.txt, 
далее в classpath добавить junit-platform-console-standalone-1.3.2.jar
и скомпилированную директорию test-classes.
далее вызвать org.junit.platform.console.ConsoleLauncher и передать туда файл с настройками @junitArgsForConsoleLauncher.txt
вот как в целом выглядит для моей системы, правда здесь с разрывами строк. Команда эта так же лежит в commandtorun.txt
java -cp 
C:/Users/Nwoaah/.m2/repository/org/junit/platform/junit-platform-console-standalone/1.3.2/junit-platform-console-standalone-1.3.2.jar;
D:/trashtest-master/TestsForDividing/target/test-classes org.junit.platform.console.ConsoleLauncher @junitArgsForConsoleLauncher.txt

Эта команда так же создает отчет в xml формате, в junitArgsForConsoleLauncher.txt можно указать директорию репорта, так читать удобнее, 
чем через консоль.
Проблема этого метода, что слишком много пишет в консоль всего, особенно все эксепшены при падающих тестах.
Их не глушил так же в силу нехватки времени

Поэтому считаю, что лучше всего запускать через maven, например mvn clean test, он очень неплохо все выводит в консоль.

Что касается того, как запускать тесты:
1. Сам проект в IDE.
2. Указанной выше командой в cmd.(указал как что и почему), кстати, на bash у меня данная команда не запустилась, проблему не решил.
3. mvn test (можно clean test, если что-то поменялось)
