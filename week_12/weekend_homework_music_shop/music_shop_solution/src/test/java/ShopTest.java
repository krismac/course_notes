import behaviours.ISell;
import music_shop.Guitar;
import music_shop.MusicBook;
import music_shop.Shop;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShopTest {
    Shop shop;
    ISell item;

    @Before
    public void before() {
        shop = new Shop("Ray's Music Exchange");
        item = new MusicBook("The Six Chord Songbook", 3, 5);
    }

    @Test
    public void hasName() {
        assertEquals("Ray's Music Exchange", shop.getName());
    }

    @Test
    public void stockStartsEmpty() {
        assertEquals(0, shop.stockCount());
    }

    @Test
    public void canAddToStock() {
        shop.addToStock(item);
        assertEquals(1, shop.stockCount());
    }

    @Test
    public void canAddGuitarToStock() {
        item = new Guitar("Gibson SG", "Cherry Red", 6, 400, 500);
        shop.addToStock(item);
        assertEquals(1, shop.stockCount());
    }

    @Test
    public void canRemoveItemFromStock() {
        shop.addToStock(item);
        shop.removeFromStock(item);
        assertEquals(0, shop.stockCount());
    }

}