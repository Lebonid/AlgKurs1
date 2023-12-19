package UI;

import Entity.LibraryEntity;
import Manager.LibraryManager;
import Utils.BaseForm;
import Utils.CustomTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainTableForm extends BaseForm {
    private JPanel mainPanel;
    private JTable table1;
    private JButton SortButton;
    private JButton SearchButton;

    private CustomTableModel<LibraryEntity> model;

    public MainTableForm() {

        setContentPane(mainPanel);

        this.initTable();
        this.initButtons();

        setVisible(true);
    }
    private void initTable(){
        table1.getTableHeader().setReorderingAllowed(false);
        table1.setRowHeight(50);

        model = new CustomTableModel<LibraryEntity>(
                LibraryEntity.class,
                new String[] {"ISBN","Название Книги","Автор","Количество Страниц"},
                LibraryManager.ReadFile()
        );
        table1.setModel(model);
    }

    private void initButtons()
    {
        SortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model = new CustomTableModel<LibraryEntity>(
                        LibraryEntity.class,
                        new String[] {"ISBN","Название Книги","Автор","Количество Страниц"},
                        model.heapSort(LibraryManager.ReadFile())
                );
                table1.setModel(model);
            }
        });

        SearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchForm(MainTableForm.this);
            }
        });
    }



    @Override
    public int getFormWidth() {
        return 1200;
    }

    @Override
    public int getFormHeight() {
        return 700;
    }
}
