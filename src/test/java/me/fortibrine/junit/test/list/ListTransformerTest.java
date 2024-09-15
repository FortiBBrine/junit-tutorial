package me.fortibrine.junit.test.list;

import me.fortibrine.junit.list.Item;
import me.fortibrine.junit.list.ListTransformer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListTransformerTest {

    private static ListTransformer transformer;

    @BeforeAll
    public static void setup() {
        transformer = new ListTransformer();
    }

    @Test
    public void containsLetterTest() {
        Item item1 = new Item(10, "raspberry");
        Item item2 = new Item(20, "banana");
        Item item3 = new Item(1, "apricot");

        List<Item> items = List.of(item1, item2, item3);

        CharSequence sequence = "b";
        List<Item> itemsWithB = transformer.containsLetter(sequence, items);
        List<Item> expected = List.of(item1, item2);

        assertThat(itemsWithB).isNotNull();
        assertThat(itemsWithB.size()).isEqualTo(expected.size());
        assertThat(itemsWithB).hasSameElementsAs(expected);

    }


    @Test
    public void containsLetterTestSorted() {
        Item item1 = new Item(10, "raspberry");
        Item item2 = new Item(20, "banana");
        Item item3 = new Item(1, "apricot");

        List<Item> items = List.of(item1, item2, item3);

        CharSequence sequence = "b";
        List<Item> itemsWithB = transformer.containsLetterAndSort(sequence, items);
        List<Item> expected = List.of(item1, item2);

        assertThat(itemsWithB).isNotNull();
        assertThat(itemsWithB.size()).isEqualTo(expected.size());
        // this method checks is elements of one array in other array. Ignore duplicate and order
        assertThat(itemsWithB).hasSameElementsAs(expected);
        assertThat(itemsWithB).isSortedAccordingTo(Item::compareTo);
        // but this method checks order and duplicate
//        assertThat(itemsWithB).containsExactlyElementsOf(expected);
    }

}
