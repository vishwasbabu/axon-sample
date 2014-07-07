/**
 * Copyright 2014 Markus Geiss
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package lab.mifos.client.api.event;

public class ClientApprovedEvent {

    private final String uniqueId;
    private final Boolean approved;
    private final String comment;

    public ClientApprovedEvent(final String uniqueId, final Boolean approved, final String comment) {
        super();
        this.uniqueId = uniqueId;
        this.approved = approved;
        this.comment = comment;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public Boolean getApproved() {
        return approved;
    }

    public String getComment() {
        return comment;
    }
}
