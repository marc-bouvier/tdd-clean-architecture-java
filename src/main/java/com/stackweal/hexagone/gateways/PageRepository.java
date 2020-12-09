package com.stackweal.hexagone.gateways;

import com.stackweal.hexagone.models.Page;

public interface PageRepository {

    Page byId(String pageId);
}
