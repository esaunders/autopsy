/*
 * Autopsy Forensic Browser
 *
 * Copyright 2020 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.datasourcesummary.datamodel;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.sleuthkit.datamodel.DataSource;

/**
 * Provides summary information about top domains in a datasource. At this time,
 * the data being provided is fictitious and is done as a placeholder.
 */
public class DataSourceTopDomainsSummary {

    private static final long SLEEP_TIME = 5000;

    /**
     * A function to calculate a result from 2 parameters.
     */
    interface Function2<A1, A2, O> {

        O apply(A1 a1, A2 a2);
    }

    /**
     * Gets a list of recent domains based on the datasource.
     *
     * @param dataSource The datasource to query for recent domains.
     * @param count      The max count of items to return.
     *
     * @return The list of items retrieved from the database.
     *
     * @throws InterruptedException
     */
    public List<TopDomainsResult> getRecentDomains(DataSource dataSource, int count) throws InterruptedException {
        Thread.sleep(SLEEP_TIME);
        final String dId = Long.toString(dataSource.getId());
        final Function2<String, Integer, String> getId = (s, idx) -> String.format("d:%s, f:%s, i:%d", dId, s, idx);
        return IntStream.range(0, count)
                .mapToObj(num -> new TopDomainsResult(
                getId.apply("domain", num),
                getId.apply("url", num),
                (long) num,
                new Date(((long) num) * 1000 * 60 * 60 * 24)
        ))
                .collect(Collectors.toList());
    }
}