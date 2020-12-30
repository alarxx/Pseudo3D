package Input;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
* Adapter-ы предоставляют пустую реализацию всех методов интерфейса приемников.
* Реализация обработчика событий WindowListener (остальные методы по ум. пустые).
 **/

public class MyWindowAdapter extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
}
