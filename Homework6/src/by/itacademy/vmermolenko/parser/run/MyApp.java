package by.itacademy.vmermolenko.parser.run;

import java.util.ArrayList;
import java.util.List;

import by.itacademy.vmermolenko.parser.model.*;
/*
 *
 Создать программу обработки текста учебника по программированию с ис-
пользованием классов: Символ, Слово, Предложение, Абзац, Лексема, Листинг,
Знак препинания и др. Во всех задачах с формированием текста заменять табу-
ляции и последовательности пробелов одним пробелом.

ИСПОЛЬЗОВАНИЕ КЛАССОВ И БИБЛИОТЕК

196
Предварительно текст следует разобрать на составные части, выполнить
одно из перечисленных ниже заданий и вывести полученный результат.

1. Найти наибольшее количество предложений текста, в которых есть одина-
ковые слова.

2. Вывести все предложения заданного текста в порядке возрастания количест-
ва слов в каждом из них.

3. Найти такое слово в первом предложении, которого нет ни в одном
из остальных предложений.

4. Во всех вопросительных предложениях текста найти и напечатать без по-
вторений слова заданной длины.

5. В каждом предложении текста поменять местами первое слово с послед-
ним, не изменяя длины предложения.

6. Напечатать слова текста в алфавитном порядке по первой букве. Слова, на-
чинающиеся с новой буквы, печатать с красной строки.

7. Рассортировать слова текста по возрастанию доли гласных букв (отноше-
ние количества гласных к общему количеству букв в слове).

8. Слова текста, начинающиеся с гласных букв, рассортировать в алфавитном
порядке по первой согласной букве слова.
9. Все слова текста рассортировать по возрастанию количества заданной буквы
в слове. Слова с одинаковым количеством расположить в алфавитном порядке.
10. Существует текст и список слов. Для каждого слова из заданного списка

найти, сколько раз оно встречается в каждом предложении, и рассортиро-
вать слова по убыванию общего количества вхождений.

11. В каждом предложении текста исключить подстроку максимальной длины,
начинающуюся и заканчивающуюся заданными символами.
12. Из текста удалить все слова заданной длины, начинающиеся на согласную
букву.

13. Отсортировать слова в тексте по убыванию количества вхождений заданно-
го символа, а в случае равенства — по алфавиту.

14. В заданном тексте найти подстроку максимальной длины, являющуюся па-
линдромом, т. е. читающуюся слева направо и справа налево одинаково.

15. Преобразовать каждое слово в тексте, удалив из него все следующие (пре-
дыдущие) вхождения первой (последней) буквы этого слова.

16. В некотором предложении текста слова заданной длины заменить указан-
ной подстрокой, длина которой может не совпадать с длиной слова.
 * */
public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "В тексте письма Минобра, которое подписано первым заместителем министра образования Ириной Старовойтовой, говорится о поручении Совмина от 4 октября 2018 года № 05/209−440/11284р. В документе отмечается, что «наличие достаточно большого числа выпускников учреждений образования, распределенных (направленных на работу) и не приступивших к работе в соответствии с законодательством, свидетельствует о недостаточной работе учреждений образования с самими выпускниками и заказчиками кадров, а также о невыполнении в полном объеме заказа на подготовку кадров».\r\n" + 
				"Читать полностью:  https://finance.tut.by/news615010.html."
				+ "В тексте письма Минобра.";
		
		
		
		
		
		//List<Sentence> listSentence = new ArrayList<Sentence>();
		
		String[] resultParagraph = text.split("\\r\\n");
		
		
		for (int i = 0; i < resultParagraph.length; i++) {
			System.out.println(resultParagraph[i]);
			
		}
		
		
		
		List<Paragraph> listParagraph  = new ArrayList<Paragraph>();
		for (int i = 0; i < resultParagraph.length; i++) {
			
			String[] resultSentence = resultParagraph[i].split("\\.");
			
			/*
			System.out.println("Предложения" + resultSentence.length);
			System.out.println(resultParagraph[i]);
			System.out.println();
			*/
			
			List<Sentence> listSentence = new ArrayList<Sentence>();
			
			for (int j = 0; j < resultSentence.length; j++) {
				
				//String[] resultWord = resultSentence[j].split("[,;:.!?\\\\s]+");
				String[] resultWord = resultSentence[j].split(" ");
				
				
				/*
				System.out.println("Слова" + resultWord.length);
				System.out.println(resultSentence[j]);
				System.out.println();
				*/
				
				List<Word> listWord = new ArrayList<Word>();
				for (int k = 0; k < resultWord.length; k++) {
					
					char[] resultSymbol= resultWord[k].toCharArray();
					//System.out.println("resultSymbol " + resultSymbol.length);
					
					List<Symbol> listSymbol = new ArrayList<Symbol>(); 
					for (int l = 0; l < resultSymbol.length; l++) {
			
						listSymbol.add(new Symbol(resultSymbol[l]));
					}
					
					Word word = new Word(listSymbol);					
					listWord.add(word);
				}
				
				Sentence sentence = new Sentence(listWord);
				listSentence.add(sentence);
				
				
			}
			
			Paragraph paragraph = new Paragraph(listSentence);
			listParagraph.add(paragraph);
			
			
		}
		
		System.out.println();
		System.out.println();
		System.out.println("out");
		Listing list = new Listing(listParagraph);
		
		list.printListing();
		
		
		int countSentence = list.countSentenceIdenticalWords();
		
		
		
		System.out.println("countSentenceIdenticalWords: " + countSentence);
		
		
		
		
		
	}

}