---
-- #%L
-- ff4j-store-jdbc
-- %%
-- Copyright (C) 2013 Ff4J
-- %%
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- 
--      http://www.apache.org/licenses/LICENSE-2.0
-- 
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
-- #L%
---
INSERT INTO FF4J_FEATURES(UID, ENABLE, DESCRIPTION) VALUES('first',  1, 'FisrtJDBC');
INSERT INTO FF4J_FEATURES(UID, ENABLE, DESCRIPTION) VALUES('second', 0, 'SecondJDBC');
INSERT INTO FF4J_FEATURES(UID, ENABLE, DESCRIPTION) VALUES('third',  0, 'ThirdJDBC');
INSERT INTO FF4J_FEATURES(UID, ENABLE, DESCRIPTION) VALUES('forth',  1, 'ForthJDBC');

INSERT INTO FF4J_ROLES(FEAT_UID, ROLE_NAME)  VALUES('first', 'ROLE_USER');
INSERT INTO FF4J_ROLES(FEAT_UID, ROLE_NAME)  VALUES('second', 'ROLE_USER');
INSERT INTO FF4J_ROLES(FEAT_UID, ROLE_NAME)  VALUES('third', 'X');
INSERT INTO FF4J_ROLES(FEAT_UID, ROLE_NAME)  VALUES('third', 'Y');
INSERT INTO FF4J_ROLES(FEAT_UID, ROLE_NAME)  VALUES('forth', 'X');
INSERT INTO FF4J_ROLES(FEAT_UID, ROLE_NAME)  VALUES('forth', 'Y');


