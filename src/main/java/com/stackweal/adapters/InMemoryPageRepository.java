package com.stackweal.adapters;

import com.stackweal.hexagone.gateways.PageRepository;
import com.stackweal.hexagone.models.Page;

public class InMemoryPageRepository implements PageRepository {
    @Override
    public Page byId(String pageId) {
        return null;
    }
}
