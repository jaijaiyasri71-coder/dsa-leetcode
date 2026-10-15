class Trie {
    String[] words = new String[1000];
    int count = 0;

    public Trie() {
    }

    public void insert(String word) {
        words[count++] = word;
    }

    public boolean search(String word) {
        for (int i = 0; i < count; i++) {
            if (words[i].equals(word))
                return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        for (int i = 0; i < count; i++) {
            if (words[i].startsWith(prefix))
                return true;
        }
        return false;
    }
}
