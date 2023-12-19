package UI;

import Entity.BinaryTree;
import Entity.LibraryEntity;
import Manager.LibraryManager;
import Utils.BaseSubForm;
import Utils.DialogUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.List;

public class SearchForm extends BaseSubForm<MainTableForm> {


    private JPanel mainPanel;
    private JTextField authField;
    private JButton searchButton;
    private JButton backButton;

    public SearchForm(MainTableForm mainForm) {
        super(mainForm);
        this.setContentPane(mainPanel);


        this.initButton();

        this.setVisible(true);

    }

    private void initButton(){
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeSubForm();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                search();
            }
        });
    }



    private void search(){
        List<LibraryEntity> libraryEntityList = LibraryManager.ReadFile();

        BinaryTree<LibraryEntity> binaryTree = new BinaryTree<>();

        Comparator<LibraryEntity> comparator = Comparator.comparing(LibraryEntity::getTitle);

        for(LibraryEntity entity: libraryEntityList)
        {
            binaryTree.insert(entity, comparator);
        }

        LibraryEntity searchKey = new LibraryEntity(0, authField.getText(), "" , 0);
        LibraryEntity foundEntity = binaryTree.search(searchKey, comparator);

        if (foundEntity != null) {
            DialogUtil.showInfo("Найден элемент: " + foundEntity.getAuthor() + "\nКнига: " + foundEntity.getTitle() + "\nСтраницы: " + foundEntity.getCountPage() +"\nISBN: " + foundEntity.getIsbn() );
        } else {
            DialogUtil.showInfo("Элемент не найден.");
        }
    }

    @Override
    public int getFormWidth() {
        return 400;
    }

    @Override
    public int getFormHeight() {
        return 300;
    }
}
