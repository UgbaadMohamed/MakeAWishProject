package com.example.makeawishproject.model;

public class Item {
        private String item_name;
        private int item_id;
        private String item_description;
        private int wishlist_id;
        private boolean reserved;

        public Item() {

        }

        public Item(String item_name, int item_id, String item_description, int wishlist_id, boolean reserved) {
            this.item_name = item_name;
            this.item_id = item_id;
            this.item_description = item_description;
            this.wishlist_id = wishlist_id;
            this.reserved = reserved;
        }

        public int getWishlist_id() {
            return wishlist_id;
        }

        public void setWishlist_id(int wishlist_id) {
            this.wishlist_id = wishlist_id;
        }

        public String getItem_name() {
            return item_name;
        }

        public void setItem_name(String item_name) {
            this.item_name = item_name;
        }

        public String getItem_description() {
            return item_description;
        }

        public void setItem_description(String item_description) {
            this.item_description = item_description;
        }
        public int getItem_id() {
            return item_id;
        }

        public void setItem_id(int item_id) {
            this.item_id = item_id;
        }

    public boolean isReserved()
    {
        return reserved;
    }

    public void setReserved(boolean reserved)
    {
        this.reserved = reserved;
    }

    @Override
        public String toString() {
            return "Item{" +
                    "item_name='" + item_name + '\'' +
                    ", item_id=" + item_id +
                    ", item_description='" + item_description + '\'' +
                    ", wishlist_id=" + wishlist_id +
                    '}';
        }

}
