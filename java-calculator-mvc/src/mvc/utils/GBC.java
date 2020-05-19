package mvc.utils;

import java.awt.*;

/**
 * GBC
 * Этот класс упрощает применение
 * класса GridBagConstraints
 * @version 1.0 25-02-2020
 * @author Bekjan Bubakanov
 */
public class GBC extends GridBagConstraints {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Строит объект типа GBC, накладывая ограничения
     * с помощью параметров gridx и gridy, а все остальные
     * ограничения накладываются на сеточно-контейнерную
     * компоновку по умолчанию
     * @param gridx Местоположение в сетке по горизонтали 
     * @param gridy Местоположение в сетке по вертикали
     */
    public GBC(int gridx, int gridy) {
        this.gridx = gridx;
        this.gridy = gridy;
    }

    /**
     * Строит объект типа GBC, накладывая ограничения
     * с помощью параметров gridx, gridy, gridwidth,
     * gridheight, а все остальные ограничения
     * накладываются на сеточно-контейнерную
     * компоновку по умолчанию
     * @param gridx Местоположение в сетке по горизонтали 
     * @param gridy Местоположение в сетке по вертикали
     * @param gridwidth Шаг сетки по горизонтали
     * @param gridheight Шаг сетки по вертикали
     */
    public GBC(int gridx, int gridy, int gridwidth, int gridheight) {
        this.gridx = gridx;
        this.gridy = gridy;
        this.gridwidth = gridwidth;
        this.gridheight = gridheight;
    }

    /**
     * Устанавливает привязку к сетке
     * @param anchor Степень привязки
     * @return this Объект для последующего видоизменения
     */
    public GBC setAnchor(int anchor) {
        this.anchor = anchor;
        return this;
    }

    /**
     * Устанавливает направление для заполнения
     * @param fill Направление заполнения 
     * @return this Объект для последующего видоизменения
     */
    public GBC setFill(int fill) {
        this.fill = fill;
        return this;
    }

    /**
     * Устанавливает веса ячеек 
     * @param weightx Вес ячейки по горизонтали
     * @param weighty Вес ячейки по вертикали
     * @return this Объект для последующего видоизменения
     */
    public GBC setWeight(double weightx, double weighty) {
        this.weightx = weightx;
        this.weighty = weighty;
        return this;
    }

    /**
     * Вводит пробелы вокруг данной ячейки
     * @param distance Пробел по всем направлениям
     * @return this Объект для последующего видоизменения
     */
    public GBC setInsets(int distance) {
        this.insets = new Insets(distance, distance, distance, distance);
        return this;
    }

    /**
     * Вводит пробелы вокруг данной ячейки 
     * @param top Пробел сверху
     * @param left Пробел слева
     * @param bottom Пробел снизу
     * @param right Пробел справа
     * @return this Объект для последующего видоизменения
     */
    public GBC setInsets(int top, int left, int bottom, int right) {
        this.insets = new Insets(top, left, bottom, right);
        return this;
    }

    /**
     * Устанавливает внутреннее заполнение
     * @param ipadx Внутреннее заполнение по горизонтали
     * @param ipady Внутреннее заполнение по вертикали
     * @return this Объект для последующего видоизменения
     */
    public GBC setIpad(int ipadx, int ipady) {
        this.ipadx = ipadx;
        this.ipady = ipady;
        return this;
    }
}