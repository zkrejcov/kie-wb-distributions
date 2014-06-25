/*
 * Copyright 2013 JBoss by Red Hat.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kie.config.cli.command.impl;

import java.util.Collection;

import org.guvnor.structure.deployment.DeploymentConfig;
import org.guvnor.structure.deployment.DeploymentConfigService;
import org.jboss.weld.environment.se.WeldContainer;
import org.kie.config.cli.CliContext;
import org.kie.config.cli.command.CliCommand;

public class ListDeploymentsCliCommand implements CliCommand {

	@Override
	public String getName() {
		return "list-deployment";
	}

	@Override
	public String execute(CliContext context) {
		StringBuffer result = new StringBuffer();
		WeldContainer container = context.getContainer();

		DeploymentConfigService deploymentConfigService = container.instance().select(DeploymentConfigService.class).get();
		Collection<DeploymentConfig> deployments = deploymentConfigService.getDeployments();

		result.append("Currently available deployments: \n");
		for (DeploymentConfig config : deployments) {
			result.append("\tDeployment " + config.getIdentifier() + "\n");
			
		}
		return result.toString();
	}

}
