package me.felek.fenix;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @className: TestingLists
 * @author: Felek
 * @date: 23.07.2026 16:01
 */

public class TestingLists {
    private Map<String, Long> languageCounts;

    public TestingLists(Map<String, Long> languageCounts) {
        this.languageCounts = languageCounts;
    }

    public Map<String, Long> getLanguageCounts() {
        return languageCounts;
    }
}
