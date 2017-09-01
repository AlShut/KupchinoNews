Данное приложение разработано для новостного портала "Новости Купчино"
http://kupchinonews.ru/

  Приложение включает в себя возможность отправки новости на электронную почту редактора, чат и новстную ленту.

  Для реализации отправки поста редактору использовались библиотеки javamail-android. Такой метод имеет ряд преимуществ перед использованием встроенных возможностей: клиенту не требуется настроенный на смартфоне почтовый клиент, отправка поста совершенно анонимна, а также можно передавать практически любые файлы. 
Для этого необходимы два зарегистрированных почтовых ящика, один из которых будет служить шлюзом, через которых будут проходить письма, а второй и будет почтовым ящиком редакции.
  Таким образом в классе ExtendedMail.java в 91 и 92 строке нужно указать адреса почтовых ящиков:
	      
        from = ""; // почта-шлюз
	where = "";// почта редактора
        
  И передаются в конструктор проль и логин от ящика, используемого как шлюз

        MailSenderClass sender = new MailSenderClass("email", "password");
  
  Настройки для ящика: https://support.google.com/mail/answer/7104828?hl=en&visit_id=1-636398746496549919-3964583765&rd=3
В этом приложении можно послать текст и одну видеозапись. Видеозапись нужно выбрать из памяти смартфона.

  Для создания и работы чата использовался firebase – backend service от Google. Firebase предоставляет бэкенд, простой в использовании SDK и готовые библиотеки пользовательского интерфейса для реализации аутентификации пользователей в приложении. Он поддерживает аутентификацию как с помощью email и пароля, так и с помощью таких популярных поставщиков идентификации, как Google, Facebook, Twitter и GitHub. Сервис аутентификации тесно интегрируется с другими сервисами Firebase, использует отраслевые стандарты, такие как OAuth 2.0 и OpenID Connect, так что он может быть легко интегрирован с бэкэндом.  В данном приложении используется аутентификация при помощи электронной почты и пароля. В консоли разработчика можно отслеживать всех зарегистрировавшихся пользователей, добавлять новых или удалять имеющихся. 
  Так как использовался беспланый аккаунт, то имеется ряд ограничений, о которых подробнее можно прочитать здесь:
  https://firebase-info.com/2017/02/03/firebase-%D1%86%D0%B5%D0%BD%D1%8B-%D1%87%D1%82%D0%BE-%D0%B1%D0%B5%D1%81%D0%BF%D0%BB%D0%B0%D1%82%D0%BD%D0%BE-%D1%87%D1%82%D0%BE-%D0%BF%D0%BB%D0%B0%D1%82%D0%BD%D0%BE/
 

